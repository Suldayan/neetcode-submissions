class MinStack {
    private int[] stack;
    private int[] min;
    private int index;

    public MinStack() {
        stack = new int[1];
        min = new int[1];
        index = 0;        
    }

    private void resize() {
        int size = stack.length;
        if (size >= Integer.MAX_VALUE / 2) {
            size = Integer.MAX_VALUE - 8;
        }
        else if (size == stack.length) {
            size *= 2;
        }

        stack = Arrays.copyOf(stack, size);
        min = Arrays.copyOf(min, size);
    }

    private void setMin(final int val) {
        min[index] = Math.min(min[index - 1], val);
    }
    
    public void push(int val) {
        if (index == stack.length) {
            resize();
        }
        
        if (index == 0) {
            min[index] = val;
        } else {
            setMin(val);
        }

        stack[index] = val;
        index++;
    }
    
    public void pop() {
        index--;
    }
    
    public int top() {
        return stack[index - 1];
    }
    
    public int getMin() {
        return min[index - 1];
    }
}
