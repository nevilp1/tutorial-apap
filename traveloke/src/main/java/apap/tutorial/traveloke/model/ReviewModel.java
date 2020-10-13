package apap.tutorial.traveloke.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "review")
public class ReviewModel implements Serializable {
    public long getIdReview() {
        return idReview;
    }

    public void setIdReview(long idReview) {
        this.idReview = idReview;
    }

    public String getNamaReviewer() {
        return namaReviewer;
    }

    public void setNamaReviewer(String namaReviewer) {
        this.namaReviewer = namaReviewer;
    }

    public Integer getIsiReview() {
        return isiReview;
    }

    public void setIsiReview(Integer isiReview) {
        this.isiReview = isiReview;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReview;

    @NotNull
    @Size(max=10)
    @Column(name="namaReviewer", nullable = false)
    private String namaReviewer;

    @NotNull
    @Size(max=50)
    @Column(name="isiReview", nullable = false)
    private Integer isiReview;

    @Size(max=50)
    @Column(name="saran")
    private String saran;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idKamar", referencedColumnName = "noKamar", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;


}
