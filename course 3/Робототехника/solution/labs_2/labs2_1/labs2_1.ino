//7. при первом нажатии кнопки начинает мигать первый светодиод, при втором
//нажатии первый светодиод гаснет и начинает мигать третий и второй светодиод,
//при третьем нажатии второй светодиод гаснет и начинает мигать первый.



void setup() {
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(2,INPUT_PULLUP);

}

void loop() {
  int sv = digitalRead(2);
  if(sv == LOW){
    sos(8,1);delay(2000);
  }
  

}

void sos(int pin, int count) {
 for (int i = 0; i < count; i++){
  digitalWrite(pin, HIGH); 
  delay(200);
  digitalWrite(pin, LOW);
  delay(200);
  }
}
