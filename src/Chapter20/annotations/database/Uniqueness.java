//: annotations/database/Uniqueness.java
// Sample of nested annotations
package Chapter20.annotations.database;

public @interface Uniqueness {
  Constraints constraints()
    default @Constraints(unique=true);
} ///:~
