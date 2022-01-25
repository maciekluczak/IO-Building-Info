import axios from "axios";

const BASE_API = 'https://io-building-info.herokuapp.com';
// const BASE_API = 'http://localhost:8080'
export const Api = {
    postBuilding: async function (building) {
        return  await axios.post(BASE_API + '/buildings', building);
    },
    getBuildings: async function(){
        return await axios.get(BASE_API + '/buildings');
    }
}