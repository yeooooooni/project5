package com.example.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int insertBoard(BoardVO vo){
        String sql = "insert into BOARD2 (title, writer, content, category) values ("
                +"'" + vo.getTitle() + "',"
                +"'" + vo.getWriter() + "',"
                +"'" + vo.getContent() + "',"
                +"'" + vo.getCategory() + "')";
        return jdbcTemplate.update(sql);
    }
    public int deleteBoard(int seq){
        String sql = "delete from BOARD2 where seq=" + seq;
        return jdbcTemplate.update(sql);
    }

    public int updateBoard(BoardVO vo){
        String sql = "update BOARD2 set title='" + vo.getTitle() + "',"
                +"writer='"+vo.getWriter() + "',"
                +"content='"+vo.getContent() + "',"
                +"category='"+vo.getCategory() + "' where seq =" + vo.getSeq();

        return jdbcTemplate.update(sql);
    }
    class BoardRowMapper implements RowMapper<BoardVO> {
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardVO one = new BoardVO();
            one.setSeq(rs.getInt("seq"));
            one.setTitle(rs.getString("title"));
            one.setWriter(rs.getString("writer"));
            one.setContent(rs.getString("content"));
            one.setCategory(rs.getString("category"));
            one.setRegdate(rs.getDate("regdate"));

            return one;
        }
    }
    public List<BoardVO> getBoardList(){
        String sql = "select * from BOARD2 order by regdate desc";
        System.out.print("get Board List well ! ");
        return jdbcTemplate.query(sql, new BoardRowMapper());
    }

    public BoardVO getBoard(int seq){
        String sql = "select * from BOARD2 where seq=" + seq;
        return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
    }




}
