import com.google.android.gms.maps.model.LatLng;

public class LatLongANDName {
    private LatLng point;
    public String name;

    public LatLongANDName(double latitude, double longitude, String name)
    {
        this.point = new LatLng(latitude, longitude);
        this.name = name;
    }
    public LatLongANDName(LatLng point, String name) {
        this.point = point;
        this.name = name;
    }
    public LatLng getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }
    public static final LatLongANDName[] locations = {
            new LatLongANDName(42.0947, -88.0657, "Fremd High School"),
    };




}
