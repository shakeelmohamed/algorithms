#include <iostream>

using namespace std;

void selectionSort(int* list, unsigned size)
{
    if (!list || size == 0)
        return;
    for (int i = 0; i < size; i++)
    {
        for (int j = i; j < size; j++)
        {
            if (list[j] < list[i]) {
                int temp = list[j];
                list[j] = list[i];
                list[i] = temp;
            }
        }
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
    selectionSort(list, size);
    for (int i = 0; i < size; i++)
    {
        cout << list[i] << endl;
    }
    return 0;
}