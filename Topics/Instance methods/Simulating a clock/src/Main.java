class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {

        if (this.minutes < 59){
            this.minutes += 1;
        }
        else {
            this.minutes = 0;
            if (this.hours <= 11){
                this.hours += 1;
            }
            else {
                this.hours = 1;
            }

        }
    }
}