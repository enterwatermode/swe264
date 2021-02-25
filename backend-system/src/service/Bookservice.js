import axios from 'axios';

const api = "http://localhost:8080/data/content";

class Bookservice {
    getBooks () {
        return axios.get(api);
    }
}

export default new Bookservice();