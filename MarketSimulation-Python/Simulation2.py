import random
from collections import deque
from Customer import Customer

def simulate_single_queue(arrival_probability, num_registers, total_minutes):
    # Single shared queue for all registers.
    queue = deque()
    registers = [None for _ in range(num_registers)]
    
    waiting_times = []

    for current_minute in range(total_minutes):
        # Check if a customer arrives
        if random.random() < arrival_probability:
            service_time = random.randint(1, 5)
            new_customer = Customer(current_minute, service_time)
            queue.append(new_customer)

        # Process registers
        for i in range(num_registers):
            if registers[i] is None:  # Register is free
                if queue:  # There are customers waiting
                    customer = queue.popleft()  # Take the first customer from the queue
                    waiting_time = current_minute - customer.arrival_time
                    waiting_times.append(waiting_time)

                    # Assign customer to register with service time
                    registers[i] = (customer, customer.service_time)
            else:
                # Reduce service time for the customer at the register
                customer, remaining_time = registers[i]
                if remaining_time > 1:
                    registers[i] = (customer, remaining_time - 1)
                else:
                    registers[i] = None  # Free the register

    # Calculate average waiting time
    average_wait = sum(waiting_times) / len(waiting_times) if waiting_times else 0
    return average_wait

if __name__ == "__main__":
    arrival_probability = 0.3
    num_registers = 3
    total_minutes = 1000

    avg_wait = simulate_single_queue(arrival_probability, num_registers, total_minutes)
    print(f"Average waiting time (single queue): {avg_wait:.2f} minutes")
