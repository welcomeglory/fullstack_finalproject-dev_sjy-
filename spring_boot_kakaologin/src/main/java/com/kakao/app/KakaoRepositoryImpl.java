/*
 * package com.kakao.app; import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.jdbc.core.RowMapper; import
 * org.springframework.stereotype.Repository;
 * 
 * import java.sql.ResultSet; import java.sql.SQLException; import
 * java.util.List;
 * 
 * @Repository public class KakaoRepositoryImpl implements KakaoRepository {
 * 
 * private final JdbcTemplate jdbcTemplate;
 * 
 * public KakaoRepositoryImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
 * jdbcTemplate; }
 * 
 * private static final class KakaoUserRowMapper implements RowMapper<KakaoUser>
 * {
 * 
 * @Override public KakaoUser mapRow(ResultSet rs, int rowNum) throws
 * SQLException { KakaoUser user = new KakaoUser();
 * user.setUserid(rs.getString("id")); user.setName(rs.getString("name"));
 * user.setEmail(rs.getString("email")); return user; } }
 * 
 * @Override public KakaoUser findById(String id) { return
 * jdbcTemplate.queryForObject("SELECT * FROM kakao_user WHERE id = ?", new
 * Object[]{id}, new KakaoUserRowMapper()); }
 * 
 * @Override public List<KakaoUser> findAll() { return
 * jdbcTemplate.query("SELECT * FROM kakao_user", new KakaoUserRowMapper()); }
 * 
 * @Override public void save(KakaoUser user) { jdbcTemplate.
 * update("INSERT INTO kakao_user (id, name, email) VALUES (?, ?, ?)",
 * user.getUserid(), user.getName(), user.getEmail()); }
 * 
 * @Override public void update(KakaoUser user) {
 * jdbcTemplate.update("UPDATE kakao_user SET name = ?, email = ? WHERE id = ?",
 * user.getName(), user.getEmail(), user.getUserid()); }
 * 
 * @Override public void deleteById(String id) {
 * jdbcTemplate.update("DELETE FROM kakao_user WHERE id = ?", id); } }
 */