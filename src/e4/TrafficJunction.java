package e4;

import java.util.Arrays;

public class TrafficJunction {

    private enum trafficLight {
        green,
        ambar,
        red,
        blinkingAmbar;

        private int counter;

        public trafficLight next() {
            switch (this) {
                case green: return ambar;
                case ambar: return red;
                case red: return green;
                default: throw new IllegalStateException();
            }
        }

        public String stateToString (trafficLight trafficLight) {
            if (trafficLight == TrafficJunction.trafficLight.red) {
                return "RED";
            } else if (trafficLight == TrafficJunction.trafficLight.green) {
                return "GREEN " + (counter - 5 + 1);
            } else if (trafficLight == TrafficJunction.trafficLight.ambar) {
                return "AMBER OFF " + (counter + 1);
            } else {
                return "AMBAR ON";
            }
        }

    }

    private trafficLight[] trafficLights = new trafficLight[4];
    private int counter;

    /**
     * Creates a trafic junction with four traffic lights named north , south ,
     * east and west . The north traffic light has just started its green cycle .
     */
    public TrafficJunction () {
        resetLights();
    }

    /**
     * Indicates that a second of time has passed , so the traffic light with
     * the green or amber light should add 1 to its counter . If the counter
     * passes its maximum value the color of the traffic light must change .
     * If it changes to red then the following traffic light changes to green .
     * The order is: north , south , east , west and then again north .
     */
    public void timesGoesBy () {
        counter++;
        if (counter == 15) {
            for (int i = 0; i < trafficLights.length; i++) {
                if (trafficLights[i] != trafficLight.green) continue;

                trafficLights[i].next();
            }
        } else if (counter == 20) {
            counter = 0;
            for (int i = 0; i < trafficLights.length; i++) {
                if (trafficLights[i] != trafficLight.ambar) continue;

                trafficLights[i].next();
                trafficLights[(i + 1) % trafficLights.length].next();
            }
        }
    }

    /**
     * If active is true all the traffic lights of the junction must change to
     * blinking amber ( meaning a non - controlled junction ).
     * If active is false it resets the traffic lights cycle and started again
     * with north at green and the rest at red.
     * @param active true or false
     */
    public void amberJunction ( boolean active ) {
        if(active){
            Arrays.fill(trafficLights, trafficLight.blinkingAmbar);
        } else {
            resetLights();
        }
    }
    /**
     * Returns a String with the state of the traffic lights .
     * The format for each traffic light is the following :
     * - For red colors : "[ name : RED ]"
     * - For green colors : "[ name : GREEN counter ]"
     * - For yellow colors with blink at OFF : "[ name : YELLOW OFF counter ]
     * - For yellow colors with blink at ON: "[ name : YELLOW ON]
     * Examples :
     * [ NORTH : GREEN 2][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
     * [ NORTH : AMBER OFF 5][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
     * [ NORTH : AMBER ON ][ SOUTH : AMBER ON ][ EAST : AMBER ON ][ WEST : AMBER ON]
     * @return String that represents the state of the traffic lights
     */
    @Override
    public String toString () {
        return "[ NORTH : ";
    }

    private void resetLights() {
        trafficLights[0] = trafficLight.green;
        trafficLights[1] = trafficLight.red;
        trafficLights[2] = trafficLight.red;
        trafficLights[3] = trafficLight.red;
        counter = 0;
    }
}