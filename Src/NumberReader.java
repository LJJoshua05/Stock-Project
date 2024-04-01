public class NumberReader {
    //private class variables
    private double open;
    private double high;
    private double low;
    private double close;
    private double adjClose;
    private double volume;
    private String date;
    private double max;
    //Constructor
    public NumberReader(){

    }
    //Overloaded constructor that gets date, open, high, low, close, adjClose, & volume
    public NumberReader(String date, String a, String b, String c, String d, String e, String f){
        this.date = date;
        this.open = Double.valueOf(a);
        this.high = Double.valueOf(b);
        this.low = Double.valueOf(c);
        this.close = Double.valueOf(d);
        this.adjClose = Double.valueOf(e);
        this.volume = Double.valueOf(f);
    }
    //Sets the max
    public void setMax(double m){
        this.max = m;
    }
    //Gets the spaces needed using max method to format output correctly
    public int getSpacesMax(){
        int x = 0;
        for(int i = 1; i < this.max; i *= 10){
            if(this.max > i){
                x++;
            }
        }
        return x;
    }
    //Formats the header
    public String getFormatForHeader(String str){
        return String.format("%-"+(getSpacesMax()+3)+"s", str);
    }
    //Sends in variables and return the header
    public String getSpacing(){
        String d = "Date", o = "Open", h = "High", l = "Low", c = "Close", a = "Adj c", v = "volume";
        return d+"      | "+getFormatForHeader(o)+"| "+getFormatForHeader(h)+"| "+getFormatForHeader(l)+"| "+getFormatForHeader(c)+"| "+getFormatForHeader(a)+"| "+getFormatForHeader(v)+"\n";
    }
    //Gets the format info for the numbers in the stock file
    public String getFormatInfo(double ans){
        String formatCurrent = String.format("%" + getSpacesMax() + ".2f", ans);
        return String.format("%" + (getSpacesMax() + 3) + "s", formatCurrent);
    }
    //Returns the formatted numbers from the stock
    public String getAllInfo(){
        return this.date +"| "+getFormatInfo(this.open) +"| "+getFormatInfo(this.high)+"| "+getFormatInfo(this.low)+"| "+getFormatInfo(this.close)+"| "+getFormatInfo(this.adjClose)+"| "+this.volume;
    }
    //Gets the first num, it's open value and returns it
    public double getNumOne(){
        return this.open;
    }
    //Gets the high of that stock for that day and returns it
    public double getHigh(){
        return this.high;
    }

}
