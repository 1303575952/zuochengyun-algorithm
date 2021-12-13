package chapter1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lifei801984
 * @date 2021/12/13 17:24
 */
public class Q4_CatDogQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    /**
     * 时间戳
     */
    private long count;

    public Q4_CatDogQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if ("dog".equals(pet.getPetType())) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if ("cat".equals(pet.getPetType())) {
            catQ.add(new PetEnterQueue(pet, count++));
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            return null;
        }
    }

    public Dog pollDog() {
        if (!isDogQueueEmpty()) {
            return (Dog) dogQ.poll().getPet();
        } else {
            return null;
        }
    }

    public Cat pollCat() {
        if (!isCatQueueEmpty()) {
            return (Cat) catQ.poll().getPet();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return dogQ.isEmpty() && catQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return catQ.isEmpty();
    }
}

class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getEnterPetType() {
        return pet.getPetType();
    }
}

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet {
    public Dog() {
        super(("dog"));
    }
}

class Cat extends Pet {
    public Cat() {
        super(("cat"));
    }
}