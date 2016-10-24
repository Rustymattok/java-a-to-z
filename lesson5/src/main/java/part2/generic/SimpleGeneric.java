package part2.generic;
/**
 * Class allow to work with massive. Add, edit, delete, get by index paramters.
 * @param <T>
 */
public class SimpleGeneric <T> {
    private Object[] objects;
    private int index;

    public SimpleGeneric(T[] objects) {
        this.objects = objects;
        this.index = 0;
    }
    /**
     * This method allow to add new element in massive. The size of massive is flexible.
     * @param object - add new object to massive.
     */
    public void add(T object){
        Object[] copy;
        copy = new Object [objects.length +1];
        System.arraycopy(objects,0,copy,0,objects.length);
        copy[copy.length - 1] = object;
        objects = new Object [copy.length];
        System.arraycopy(copy,0,objects,0,copy.length);
        index++;
    }
    /**
     * This method allow edite object in massive. It depends of index in massive.
     * @param index -  index  of element in massive which we need to update.
     * @param object- edited element in massive.
     */
    public void update(int index,T object){
        objects[index] = object;
    }
    /**
     * This method allow to remove element in massive. The size of massive is flexible.
     * @param index - index  of element in massive which we need to remove.
     * @return upated massive.
     */
    public Object[] delete(int index){
        Object[] copy = null;
        if (objects[index] != null){
            copy = new Object [objects.length - 1];
            System.arraycopy(objects,0,copy,0,index);
            System.arraycopy(objects,index + 1,copy,index,objects.length - index - 1);
        }
        objects = copy;
        return  objects;
    }
    /**
     * This method allow to recieve object from massive by index.
     * @param index - index  of element in massive which we need to recieve.
     * @return object.
     */
    public Object getByIndex(int index){
        return   objects[index];
    }

    public void show(){
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }

}
