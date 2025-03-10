package com.chess.classes.pieces;

    /**
     * The Piece class represents an abstract chess piece with a priority.
     * It implements the Comparable interface to allow comparison based on priority.
     */
    public abstract class Piece implements Comparable<Piece> {
        public int priority;

        /**
         * Constructs a Piece instance with a default priority of 0.
         */
        public Piece() {
            this.priority = 0;
        }

        /**
         * Gets the name of the piece.
         *
         * @return the name of the piece
         */
        public abstract String getName();


        @Override
        public int compareTo(Piece o) {
            return Integer.compare(this.priority, o.priority);
        }

        /**
         * Returns a string representation of the piece.
         *
         * @return the name of the piece
         */
        @Override
        public String toString() {
            return getName();
        }
    }