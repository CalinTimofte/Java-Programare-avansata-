package info.uaic.ro.programare_avansata.lab11.demo;

import info.uaic.ro.programare_avansata.lab11.demo.dbconn.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class Player {

    @PostConstruct
    public void init(){
        Database db = new Database();
    }

    @GetMapping
    public List<String> getPlayers(){
        int id;
        String name;
        String querry = "SELECT id, name FROM " + '"' + "Players" + '"' +";";
        List<String> returnList = new LinkedList<String>();
        try {
            Statement stmt = Database.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                returnList.add("id: " + id + " name: " + name);
            }
        } catch (SQLException e) {
            System.err.println("Get all players failed.");
        }
        return returnList;
    }

    @PostMapping
    public String createPlayer(@RequestParam String name){
        String querry = "INSERT INTO " +'"' + "Players" + '"' + " (name) VALUES (" + "'" + name + "'"  + ");";
        try {
            Statement stmt = Database.getConn().createStatement();
            stmt.execute(querry);
        } catch (SQLException e) {
            System.err.println("Insert into players failed.");
        }
        return "Insert OK";
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name){
        String querry = "UPDATE " +'"' + "Players" + '"' + " SET name = " + "'" + name + "'"  + " WHERE id = " + "'" + id + "'"  + ";";
        try{
            Statement stmt = Database.getConn().createStatement();
            stmt.execute(querry);
        } catch (SQLException e) {
            System.err.println("Update player failed.");
        }
        return new ResponseEntity<>(
                "Player updated successfully", HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id){
        String querry = "DELETE from " +'"' + "Players" + '"' + " WHERE id = " + "'" + id + "'"  + ";";
        try{
            Statement stmt = Database.getConn().createStatement();
            stmt.execute(querry);
        } catch (SQLException e) {
            System.err.println("Delete player failed.");
        }
        return new ResponseEntity<>(
                "Player deleted successfully", HttpStatus.OK
        );
    }
}
