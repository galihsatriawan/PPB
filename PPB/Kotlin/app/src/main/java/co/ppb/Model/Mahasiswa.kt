package co.ppb.Model

/**
 * Created by root on 9/27/18.
 */
class Mahasiswa {
    var nama: String? = null
    var image: Int? = null
    var nrp : String? = null

    constructor(nama: String,nrp: String, image: Int) {
        this.nama = nama
        this.image = image
        this.nrp = nrp
    }
}
