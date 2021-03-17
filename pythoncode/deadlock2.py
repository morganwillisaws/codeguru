import threading
import time

class MyThread1(threading.Thread):
    def run(self):
        # Lock mutexA
        mutexA.acquire()

        # After mutex A is locked, delay for 1 second and wait for another thread to lock mutex B
        print(self.name+'----do1---up----')
        time.sleep(1)

        # This is blocked because the mutex B has been preempted by another thread
        mutexB.acquire()
        print(self.name+'----do1---down----')
        mutexB.release()

        # Unlock mutexA
        mutexA.release()

class MyThread2(threading.Thread):
    def run(self):
        # Lock mutex B
        mutexB.acquire()

        # After mutex B is locked, delay for 1 second and wait for another thread to lock mutex a
        print(self.name+'----do2---up----')
        time.sleep(1)

        # This is blocked because the mutexA has been preempted by another thread
        mutexA.acquire()
        print(self.name+'----do2---down----')
        mutexA.release()

        # Unlock mutexB
        mutexB.release()

mutexA = threading.Lock()
mutexB = threading.Lock()

if __name__ == '__main__':
    t1 = MyThread1()
    t2 = MyThread2()
    t1.start()
    t2.start()