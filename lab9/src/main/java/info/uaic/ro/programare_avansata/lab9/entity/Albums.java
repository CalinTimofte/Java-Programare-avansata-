package info.uaic.ro.programare_avansata.lab9.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "albums")
@Entity
public class Albums implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "artist_id", nullable = false)
    private Integer artistId;

    @Column(name = "release_year")
    private Integer releaseYear;

    
}