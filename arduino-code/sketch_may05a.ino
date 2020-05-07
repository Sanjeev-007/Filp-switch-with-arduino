#include<Servo.h>
Servo servo_switch;
int pos=20;
boolean vis_on=false,vis_off=false;
void setup(){
  Serial.begin(9600);
  servo_switch.attach(8);
}
void loop(){
  if(Serial.available()){
    if(!vis_on || !vis_off){
      int a=int(Serial.read());
      if(a==1 && !vis_on){
        servo_switch.write(0);
        vis_on=true;
      }else if(a!=1 && !vis_off){
        servo_switch.write(40);
        vis_off=true;
      }
    }else{
      vis_on=false;
      vis_off=false;
    }
  }
}
