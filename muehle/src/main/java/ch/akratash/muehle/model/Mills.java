package ch.akratash.muehle.model;


import java.util.ArrayList;

import java.util.Arrays;

import java.util.Collections;

import java.util.List;

import java.util.SortedSet;

import java.util.TreeSet;

public class Mills {

	public static final Integer[][] positionToNeighboursArray = {

        // dimGrid
        // 000 
        {001,010},
        // 001
        {000,002,101},
        // 002
        {001,102},
        // 010
        {110,020},
        // 012
        {112,022,002},
        // 020
        {021,010},
        // 021
        {020,022,121},
        // 022
        {021,012},

        // colGrid
        // 100 
        {101,110},
        // 101
        {100,102,201},
        // 102
        {101,112},
        // 110
        {010,210,120,100},
        // 112
        {212,012,122,102},
        // 120
        {121,110},
        // 121
        {120,122,221},
        // 122
        {121,112},

        // rowGrid
        // 200 
        {201,210},
        // 201
        {200,202,101},
        // 202
        {201,212},
        // 210
        {110,220,200},
        // 212
        {212,222,202},
        // 220
        {221,210},
        // 221
        {220,222,121},
        // 222
        {221,212}
        
    };


	public static final Integer[][] possibleMillsArrsy = {


        //Horizontale Mills
		{000,010,020},

		{100, 110, 120},

		{200,210,220},

		{001,101,201},	/*   Mitte      */{221,121,021},

		{202,212,222},

		{102,112,122},

        {002,012,022},
        
        //Senkrechte Mills
		{000,001,002},

		{100,101,102},

		{200,201,202},

		{010,110,210 },     /*  Mitte  */       {212,112,012},

		{220,221,222},

		{120,121,122},

		{020,021,022},
    };
    
	static {

		List<List<Integer>> posToNeigh = new ArrayList<List<Integer>>();

		

		for (int i = 0; i < positionToNeighboursArray.length; i++) {

			posToNeigh.add(Collections.unmodifiableList(Arrays.asList(positionToNeighboursArray[i])));

		}

		

		List<List<Integer>> POSITION_TO_NEIGHBOURS = Collections.unmodifiableList(posToNeigh);

		

		List<List<Integer>> possMills = new ArrayList<List<Integer>>();

		

		for (int i = 0; i < possibleMillsArrsy.length; i++) {

			possMills.add(Collections.unmodifiableList(Arrays.asList(possibleMillsArrsy[i])));

		}

		

		List<List<Integer>> POSSIBLE_MILLS = Collections.unmodifiableList(possMills);

	}

}
