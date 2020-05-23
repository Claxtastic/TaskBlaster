// import axios from 'axios';

const API_URL = 'http://localhost:8080';

class TaskService {

    getAllTasks() {
        fetch(`${API_URL}/tasks`)
            .then(response => response.json())
            .then(data => console.log(data));
    }

    // TODO: Add a username to the params
    postTask(task) {
        const postOptions = {
            method: 'POST',
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json;charset=UTF-8'
            },
            body: JSON.stringify({
                
            })
        }
    }
}

export default new TaskService();
