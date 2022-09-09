public class Coordinate {

    public int easting;
    public int northing;
    public double longitude;
    public double latitude;

    public Coordinate(int easting,int northing,double longitude, double latitude){
        this.easting=easting;
        this.northing=northing;
        this.longitude=longitude;
        this.latitude=latitude;
    }

    public int getEasting() {
        return easting;
    }

    public int getNorthing() {
        return northing;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double calculateDistance(Coordinate compare){
        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        double lon1 = Math.toRadians(this.getLongitude());
        double lon2 = Math.toRadians(compare.getLongitude());
        double lat1 = Math.toRadians(this.getLatitude());
        double lat2 = Math.toRadians(compare.getLatitude());

        // Haversine formula
        double dLon = lon2 - lon1;
        double dLat = lat2 - lat1;
        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dLon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);


    }
}
