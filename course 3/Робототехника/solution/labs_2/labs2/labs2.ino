//1 раз мигает первый, гаснет, 2 раза мигает второй, гаснет, 3 раза мигает третий,гаснет.


void setup() {
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);

}

void loop() {
  sos(8,1);delay(2000);
  sos(9,2);delay(2000);
  sos(10,3);delay(2000);

}

void sos(int pin, int count) {
 for (int i = 0; i < count; i++){
  digitalWrite(pin, HIGH); 
  delay(200);
  digitalWrite(pin, LOW);
  delay(200);
  }
}
