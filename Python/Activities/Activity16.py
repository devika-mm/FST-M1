class Car:

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving")

    def stop(self):
        print(self.manufacturer + " " +self.model + " has stopped")


car1 = Car("Maruthi", "Ritz", "2014", "Manual", "White")
car2 = Car("Ford", "Figo", "2015", "Automatic", "Red")
car3 = Car("Kia", "Sonet", "2022", "Automatic", "Blue")

car1.stop()
car3.accelerate()