package com.ankit.programs.google;

import java.util.Scanner;

public class GasStationProblem
{

    public static void main(String[] args)
            throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] fuels = new int[size];
        int[] distances = new int[size];
        int fuelSum = 0, distanceSum = 0;
        for (int i = 0; i < size; i ++)
        {
            fuels[i] = scanner.nextInt();
            fuelSum += fuels[i];
        }
        for (int i = 0; i < size; i ++)
        {
            distances[i] = scanner.nextInt();
            distanceSum += distances[i];
        }

        if ( fuelSum < distanceSum) {
            System.out.println("Not possible");;
        }
        int currFuel = fuels[0];
        int startIndex = 0;
        for(int i = 1; i <= size; i++) {
          currFuel = currFuel - distances[i-1];
          if (currFuel < 0) {
              startIndex = i;
              currFuel = fuels[i];
              continue;
          }
          currFuel += fuels[i%size];
        }

        System.out.println("start from station :" + startIndex);


    }

   /* private static GasStation getGasStation()
            throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] stations = new int[size];
        int[] distances = new int[size];
        for (int i = 0; i < size; i ++)
        {
            stations[i] = scanner.nextInt();
        }
        for (int i = 0; i < size; i ++)
        {
            distances[i] = scanner.nextInt();
        }
        return new GasStation(stations, distances);
    }*/
}

/*class GasStation
{
    int[] stations;
    int[] distances;

    GasStation( int[] stations, int[] distances)
            throws Exception
    {
        if (stations.length != distances.length) {
            throw new Exception("Number of stations and distances need to be same");
        }
        this.stations = stations;
        this.distances = distances;
    }

    public int getSize()
    {
        return stations.length;
    }

}*/
