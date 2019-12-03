/**
 * A car factory has two assembly lines, each with n stations. 
 * A station is denoted by Si,j where i is either 1 or 2 and 
 * indicates the assembly line the station is on, and j indicates the number of the station. 
 * The time taken per station is denoted by ai,j. Each station is dedicated to some sort of work 
 * like engine fitting, body fitting, painting and so on. 
 * 
 * So, a car chassis must pass through each of the n stations in order before exiting the factory.
 * The parallel stations of the two assembly lines perform the same task. After it passes through station Si,j, 
 * it will continue to station Si,j+1 unless it decides to transfer to the other line. 
 * Continuing on the same line incurs no extra cost, but transferring from line i at station j – 1 to station j 
 * on the other line takes time ti,j. Each assembly line takes an entry time ei and exit time xi 
 * which may be different for the two lines.
 * 
 * Give an algorithm for computing the minimum time it will take to build a car chassis.
 */
class AssemblyLineScheduling {

    int STATION_SIZE = 4;
    int NUM_STATIONS = 2;

    public int carAssembly(int [][] a, int [][] t, int [] e, int [] x) {
        int T1[] = new int[STATION_SIZE];
        int T2[] = new int[STATION_SIZE];

        T1[0] = e[0] + a[0][0];
        T2[0] = e[1] + a[1][0];

        for (int i = 1; i < NUM_STATIONS; i++) {
            T1[i] = 
                Math.min(
                    T1[i - 1] + a[0][i], 
                    T2[i - 1] + t[1][i] + a[0][i]);

            T2[i] = 
                Math.min(
                    T2[i - 1] + a[1][i], 
                    T1[i - 1] + t[0][i] + a[1][i]);
        }

        return Math.min(T1[STATION_SIZE - 1] + x[0], T2[STATION_SIZE - 1] + x[1]);
    }
}
