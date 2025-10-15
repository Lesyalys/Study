void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
}

void loop() {
  // L (.-..)
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(300); // .
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(300); // -
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(300); // .
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(1000); // . 

  // Y (-.--)
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(300); // -
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(300); // .
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(300); // -
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(1000); // -

  // S (...)
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(300); // .
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(300); // .
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(1000); // . 

  // E (.)
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(1000); // . 

  // N (-.)
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(300); // -
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(1000); // . 

  // K (-.-)
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(300); // -
  digitalWrite(LED_BUILTIN, HIGH); delay(200); digitalWrite(LED_BUILTIN, LOW); delay(300); // .
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(1000); // - 

  // O (---)
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(300); // -
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(300); // -
  digitalWrite(LED_BUILTIN, HIGH); delay(600); digitalWrite(LED_BUILTIN, LOW); delay(2000); // -
}
