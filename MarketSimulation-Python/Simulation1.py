import random
from collections import deque
from Customer import Customer

def simulate_separate_queues(arrival_probability, num_registers, total_minutes):
   
    queues = [deque() for _ in range(num_registers)]
    
    registers = [None] * num_registers
    
    waiting_times = []

    for current_minute in range(total_minutes):
        
        if random.random() < arrival_probability:
           
            service_time = random.randint(1, 5)
            new_customer = Customer(current_minute, service_time)
            
            # Find the shortest queue and add customer
            shortest_queue = min(queues, key=len)
            shortest_queue.append(new_customer)
        
        
        for i in range(num_registers):
            if registers[i] is None: 
                if queues[i]:  
                    customer = queues[i].popleft()  
                    waiting_time = current_minute - customer.arrival_time
                    waiting_times.append(waiting_time)
                    
                    
                    registers[i] = (customer, customer.service_time)
            else:
                
                customer, remaining_time = registers[i]
                if remaining_time > 1:
                    registers[i] = (customer, remaining_time - 1)
                else:
                    registers[i] = None  #

    
    average_wait = sum(waiting_times) / len(waiting_times) if waiting_times else 0
    return average_wait

if __name__ == "__main__":
    # Simulation parameters
    arrival_probability = 0.3
    num_registers = 3
    total_minutes = 1000

    avg_wait = simulate_separate_queues(arrival_probability, num_registers, total_minutes)
    print(f"Average waiting time (separate queues): {avg_wait:.2f} minutes")
