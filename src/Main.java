public class Main
{
    static void Bubble(int[] nums) {
        for (int i = nums.length; i >= 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    static void _Quick(int[] nums, int low, int high)
    {
        int pivot = low++;
        int high_init = high;

        while (low <= high)
        {
            while (low <= high && nums[low] < nums[pivot])
                low++;
            while (low <= high && nums[high] >= nums[pivot])
                high--;

            if (low >= high)
            {
                int temp = nums[pivot];
                nums[pivot] = nums[high];
                nums[high] = temp;
                if (pivot < high - 1)
                    _Quick(nums, pivot, high - 1);
                if (high - 1 < high_init)
                    _Quick(nums, high + 1, high_init);
            }else {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }
    }

    static void Quick(int[] nums){
        _Quick(nums, 0, nums.length-1);
    }

    public static void main(String[] args)
    {
        int[] nums = {49,38,65,97,76,13,27,49};
        Quick(nums);

        for (int num :
                nums) {
            System.out.print(num + ", ");
        }
    }
}

