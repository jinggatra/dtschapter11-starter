package id.ac.polinema.dtsfit.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// TODO: Implementasikan parcelable
public class Calory implements Parcelable {

    // TODO: Generate model berdasarkan response REST

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("food")
    @Expose
    private String food;
    @SerializedName("calory")
    @Expose
    private Integer calory;

    protected Calory(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        food = in.readString();
        if (in.readByte() == 0) {
            calory = null;
        } else {
            calory = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(food);
        if (calory == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(calory);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Calory> CREATOR = new Creator<Calory>() {
        @Override
        public Calory createFromParcel(Parcel in) {
            return new Calory(in);
        }

        @Override
        public Calory[] newArray(int size) {
            return new Calory[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Integer getCalory() {
        return calory;
    }

    public void setCalory(Integer calory) {
        this.calory = calory;
    }
}
