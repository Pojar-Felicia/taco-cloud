package tacos.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import tacos.domain.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    public Ingredient findOne(String id) {
            return jdbc.queryForObject(
                    "select id, name, type from Ingredient where id=1000",
                    new RowMapper<Ingredient>() {
                        public Ingredient mapRow(ResultSet rs, int rowNum)
                                throws SQLException {
                            return new Ingredient(
                                    rs.getString("id"),
                                    rs.getString("name"),
                                    Ingredient.Type.valueOf(rs.getString("type")));
                        }; }, id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update(
                "insert into Ingredient (id, name, type) values (1000, milk, fish)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
            throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }

/***********************************************************************************************/


    @Override
    public <S extends Ingredient> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Ingredient> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Ingredient ingredient) {

    }

    @Override
    public void deleteAll(Iterable<? extends Ingredient> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}

