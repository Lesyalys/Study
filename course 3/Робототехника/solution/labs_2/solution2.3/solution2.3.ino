//7. при первом нажатии кнопки начинает мигать первый светодиод, 
//при втором – первый и второй светодиод
//при третьем – все три

int countenter = 0;

void setup() {
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(2,INPUT_PULLUP);

}

void loop() {
  bool reading = digitalRead(2);
  int sv = digitalRead(2);
  if (sv ==LOW){
    if (countenter > 3){
      countenter = 0;
      } else {
        countenter+=1;
        }
    }
  
  digitalWrite(8,(countenter >=1)? HIGH : LOW); 
  digitalWrite(9,(countenter >=2)? HIGH : LOW); 
  digitalWrite(10,(countenter >=3)? HIGH : LOW); 

  
  

}
//
//void sos(int pin, int count) {
// for (int i = 0; i < count; i++){
//  digitalWrite(pin, HIGH); 
//  delay(200);
//  digitalWrite(pin, LOW);
//  delay(200);
//  }
//}
