import React, {useEffect, useState} from 'react'
import {cn} from '@bem-react/classname'
import {Link,} from "react-router-dom";
import {Api} from "../../api";
import {Room} from "../Room/Room";
import './Main.scss'


const MainCN = cn('main')

export const Main = () => {
    const [buildings, setBuildings] = useState([])
    const getBuildings = async () => {
        const response = await Api.getBuildings();

        setBuildings(response.data);
    }
    useEffect(() => {
        getBuildings();
    }, [])
    const buildingsMapped = buildings.map((building) => {
        return (<div className={MainCN('building-container')}><h2>Building name: {building.name}</h2>
            {building.floors.map(floor => {
                return (<div className={MainCN('floor-container')}><h3>Floor: {floor.name}</h3>
                    <div className={MainCN('room-container')}>{floor.rooms.map(room => {
                        return (<Room {...room}/>)
                    })}</div>
                </div>)
            })}
        </div>)
    })
    return (<div className={MainCN('container')}>
        <section>
            <Link to={'/new'}>Add new Building</Link>
        </section>
        {buildingsMapped}
    </div>)
}