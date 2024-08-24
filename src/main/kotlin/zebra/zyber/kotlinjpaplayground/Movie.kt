package zebra.zyber.kotlinjpaplayground

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "movie")
data class Movie(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    val id: Long?,

    @Column(nullable = false)
    val title: String,

    @Column(name = "release_date", nullable = false)
    val releaseDate: LocalDate,

    @OneToMany(cascade = [(CascadeType.PERSIST)])
    @Column()
    val actors: Set<Actor>,
    )
