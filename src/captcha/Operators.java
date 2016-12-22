package captcha;

enum Operators {
    ADD {
        public Integer apply(Integer a, Integer b) { return a + b; }
        public String toString() { return "+"; }
    },
    SUBTRACT {
        public Integer apply(Integer a, Integer b) { return a - b; }
        public String toString() { return "-"; }

    },
    MULTIPLY {
        public Integer apply(Integer a, Integer b) { return a * b; }
        public String toString() { return "*"; }
    },
    ;

    public abstract Integer apply(Integer a, Integer b);
}
