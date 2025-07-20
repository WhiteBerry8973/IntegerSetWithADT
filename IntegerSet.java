import java.util.ArrayList;

/**
 * 
 * ADT IntegerSet ที่เก็บเลขจำนวนเต็มใดๆ เรียงจากน้อยไปมาก และห้ามมี null หรือตัวเลขซ้ำ
 * 
 */
    
public class IntegerSet {    
    ArrayList<Integer> Numbers;

    // Abstraction Function (AF):
    // - AF(s) = the set of Integer in the int x.
    // Rep Invariant (RI):
    // - x must not contain duplicate Integer.
    // - Integer in x must be sorted in ascending order.
    // - Integer must not be null.

    public IntegerSet() {
        Numbers = new ArrayList<>();
        CheckRep();
    }

    private void CheckRep() {
        for (int i = 0; i < Numbers.size(); i++) {
            if (Numbers.get(i) == null) {
                throw new RuntimeException("Null at index "+i);
            }
        }

        for (int i = 0; i < Numbers.size()-1; i++) {
            if (Numbers.get(i) >= Numbers.get(i+1)) {
                throw new RuntimeException("Eror sort");
            }
        }
    }

    public void add(Integer x) {
        if (x == null) {
            throw new RuntimeException("Can not add null");
        }
        if (Numbers.contains(x)) {
            return;
        }
        if (Numbers.size() == 0) {
            Numbers.add(x);
        } else if (x < Numbers.get(0)) {
            Numbers.add(0, x);
        } else if (x > Numbers.get(Numbers.size()-1)) {
            Numbers.add(x);
        } else {
            for (int i = 0; i < Numbers.size()-1; i++) {
                if (Numbers.get(i) < x && x < Numbers.get(i+1)) {
                    Numbers.add(i+1, x);
                    break;
                }
            }
        }
        CheckRep();
    }

    public void remove(Integer x) {
        if (x == null) {
            throw new RuntimeException("Can not remove null");
        }
        Numbers.remove(x);
        CheckRep();
    }

    public boolean contains(int x) {
        return Numbers.contains(x);
    }

    public int size() {
        return Numbers.size();
    }

    public String toString() {
        return Numbers.toString();
    }
}