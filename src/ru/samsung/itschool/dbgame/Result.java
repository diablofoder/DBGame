package ru.samsung.itschool.dbgame;

public class Result {
        String name;
        int score;
        Result(String name, int score)
        {
        	this.name = name;
        	this.score = score;
        }
       public String toString()
       {
    	   return this.name + this.score;
       }
}
