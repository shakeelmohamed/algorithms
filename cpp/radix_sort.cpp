#include <iostream>
#include <math.h>

using namespace std;

struct Bucket {
    int data;
    Bucket* next;
};

void radixSort(int* list, unsigned size, int power)
{
    if (!list || size == 0 || power <= 0)
        return;

    int powerOfTen = (int)pow(10.0, power);

    Bucket* bucketList[10];

    for (int i = 0; i < size; i++)
    {
        int bucket = (i % powerOfTen) - (i / powerOfTen);
        Bucket* b;
        b->data = list[i];
        b->next = 0;

        // Do appropriate insertion
        if (bucketList[bucket]) {
            Bucket* temp = bucketList[bucket];
            while (temp) {
                temp = temp->next;
            }
            temp->next = b;
        }
        else {
            bucketList[bucket] = b;
        }
    }

    // Do "swaps"
    int i = 0;
    for (int j = 0; j < 10; j++) {
        Bucket* t = bucketList[j];
        while (t && i < size) {
            list[i++] = t->data;
            Bucket* backup = t;
            t = t->next;
            delete backup;
        }
    }

    if (list[size - 1] < (powerOfTen * 10.0)) {
        return;
    }
    else {
        // Recurse, go to next power
        radixSort(list, size, power+1);
    }
}

int main()
{   int size = 6;
    int* list = new int[size];
    list[0] = 12;
    list[1] = 40;
    list[2] = 2;
    list[3] = 1;
    list[4] = 9;
    list[5] = 3;

    cout << "Unsorted" << endl;
    for (int i = 0; i < size; i++)
    {
        cout << list[i] << endl;
    }

    cout << "Sorted" << endl;
    radixSort(list, size, 0);
    for (int i = 0; i < size; i++)
    {
        cout << list[i] << endl;
    }
    return 0;
}