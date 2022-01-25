import React from 'react';
import {cn} from "@bem-react/classname";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

import './Room.scss'

const roomCN = cn('room')

export const Room = (props) => {
    const {area, cube, heating, id, light, name} = props;
    console.log(props);
    return (<div className={roomCN('container')}>
        Room: {name}
        <div><FontAwesomeIcon icon={'vector-square'} size={'1x'}/> Area: {area.toFixed(2)} ㎡</div>
        <div><FontAwesomeIcon icon={'cube'} size={'1x'}/> Cube: {cube.toFixed(2)} ㎥</div>
        <div><FontAwesomeIcon icon={'fire'} size={'1x'}/> Heating: {heating.toFixed(2)} W</div>
        <div><FontAwesomeIcon icon={'lightbulb'} size={'1x'}/> Light: {light.toFixed(2)} W</div>


    </div>)

}