import java.util.*;

class Customer{
    private string customerId;
    private customername;
    private int rollNo;
    private int unitsconsumed;
    private int rate;
    private string connectiontype;
    
    calculateBill(){
        while(connectiontype=="DOMESTIC"){
            if(unitsconsumed>0 && unitsconsumed<100){
                return rate+=2;
            }
            else if(unitsconsumed>101 && unitsconsumed<201)
            {
                return rate+=3;
            }
            else if(unitsconsumed>201 && unitsconsumed<301)
            {
                return rate+=5;
            }
            else{
                return rate+=7;
            }
        }
        while(connectiontype=="COMMERCIAL")
        {
            if(unitsconsumed>0 && unitsconsumed<101){
                return rate+=2;
            }
            else if(unitsconsumed>101 && unitsconsumed<301)
            {
                return rate+=3;
            }
            else if(unitsconsumed>301 && unitsconsumed<500)
            {
                return rate+=5;
            }
            else{
                return rate+=7;
            }

        }
    }

    calculateBill(Boolean applySurcharge){
        
    }
}