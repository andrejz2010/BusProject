package busproject;

public class Bus {
    private String id;
    private String lineName;
    private int secondsTimeToStation;

    String outputMessage;



    public String getId() {
        return id;
    }

    public String getDestinationName() {
        return destinationName;
    }

    private String destinationName;



    public int getSecondsTimeToStation() {
        return secondsTimeToStation;
    }

    public void setSecondsTimeToStation(int secondsTimeToStation) {
        this.secondsTimeToStation = secondsTimeToStation;
    }

    public Bus(String id, String lineName, int secondsTimeToStation, String destinationName ){

        this.id=id;
        this.lineName=lineName;
        this.secondsTimeToStation=secondsTimeToStation;
        this.destinationName=destinationName;
        int hours = this.secondsTimeToStation / 3600;
        int minutes = (this.secondsTimeToStation % 3600) / 60;
        int seconds = this.secondsTimeToStation % 60;

        this.outputMessage = String.format("%02d:%02d:%02d", hours, minutes, seconds);

    }

public void getArrivalMessage(){
    System.out.println("Bus "+this.lineName+" going to "+this.destinationName+ " will arrive in "+ this.outputMessage);
}
}
