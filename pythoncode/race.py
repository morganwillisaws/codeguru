from threading import Thread

class Counter(object):
    def __init__(self):
        self.value = 0
    def increment(self):
        self.value += 1

c = Counter()

def go():
    for i in range(1000000):
        c.increment()

# Run two threads that increment the counter:
t1 = Thread(target=go)
t1.start()
t2 = Thread(target=go)
t2.start()
t1.join()
t2.join()
print(c.value)