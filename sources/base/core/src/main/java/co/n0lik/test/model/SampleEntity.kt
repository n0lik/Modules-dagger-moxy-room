package co.n0lik.test.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity(tableName = "datadb")
class SampleEntity : Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

    @ColumnInfo(name = "text")
    var text: String

    constructor(id: Long?, text: String){
        this.id = id
        this.text = text
    }

    constructor(parcel: Parcel) : this(
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SampleEntity> {
        override fun createFromParcel(parcel: Parcel): SampleEntity {
            return SampleEntity(parcel)
        }

        override fun newArray(size: Int): Array<SampleEntity?> {
            return arrayOfNulls(size)
        }
    }

}