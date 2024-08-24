package zebra.zyber.kotlinjpaplayground

import jakarta.persistence.*

@Entity
@Table(name = "actor")
data class Actor (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String
)