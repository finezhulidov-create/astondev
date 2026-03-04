package homework.h3.adapter.adapters;

import homework.h3.adapter.RoundPeg;
import homework.h3.adapter.SquarePeg;

public class SquarePegAdapter extends RoundPeg {
        private SquarePeg peg;

        public SquarePegAdapter(SquarePeg peg){
            this.peg = peg;
        }

        @Override
        public double getRadius(){
            double result;
            result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
            return result;
        }
}
