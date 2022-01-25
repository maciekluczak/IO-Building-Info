import {useState} from "react";
import {Api} from "../../api";
import {cn} from "@bem-react/classname";
import './BuildingForm.scss'

const BuildingFormCN = cn('building-form')
export const BuildingForm = () => {

    const [building, setBuilding] = useState({})
    const [floorInputList, setFloorInputList] = useState([]);
    const [roomInputList, setRoomInputList] = useState([])
    const handleAddFloorClick = () => {
        setFloorInputList([...floorInputList, {name: ''}])
    }
    const handleAddRoomClick = (e, i) => {
        setRoomInputList([...roomInputList, {
            name: '',
            "area": Math.random(),
            "cube": Math.random(),
            "heating": Math.random(),
            "light": Math.random(),
            "heatingPerUnit": Math.random(),
            "lightPerUnit": Math.random(), i
        }])
    }
    const handleBuildingCreate = async (e) => {
        const buildingObject = {...building};
        buildingObject.floors = floorInputList.map((el, i) => {
            return {
                name: el.name,
                rooms: roomInputList.filter((room) => room.i === i).map(room => {
                    delete room.i;
                    return room;
                })
            }
        })
        console.log(buildingObject);
        const result = await Api.postBuilding(buildingObject);
        setBuilding({});
        setRoomInputList([]);
        setFloorInputList([]);
        console.log(result)
    }
    const handleRoomChange = (e, i, j) => {
        console.log(i, j)
        const {name, value} = e.target;
        const rooms = [...roomInputList];
        rooms[j][name] = value;
        setRoomInputList(rooms);
    }
    const handleBuildingNameChange = (e) => {
        setBuilding({...building, name: e.target.value});
    }
    const handleFloorChange = (e, i) => {
        const {name, value} = e.target;
        const floors = [...floorInputList];
        floors[i][name] = value;
        setFloorInputList(floors);
    }
    let offset = 0;
    console.log(floorInputList)
    return (<div className={BuildingFormCN('container')}><h2>Building name:</h2>
        <input type={'text'} name={'building-name'} onChange={e => handleBuildingNameChange(e)}/>
        <div className={BuildingFormCN('add-floor')}><input className={BuildingFormCN('add-button')} type={'button'} value={'Add Floor'} onClick={e => handleAddFloorClick(e)}/></div>
        {floorInputList.map((el, i) => {
            const rooms = roomInputList.filter(el => el.i === i);
            const floorInputs = (<div className={BuildingFormCN('floor-container')}>
                <div className={BuildingFormCN('floor-input')}>
                    <div>Floor#{i}</div>
                    Name: <input type={'text'} name={'name'} onChange={e => handleFloorChange(e, i)}/>
                    <input className={BuildingFormCN('add-button')} type={'button'} value={'Add Room'} onClick={e => handleAddRoomClick(e, i)}/>
                </div>
                {rooms.map((el, j) => {
                    j += offset;
                    return (<div className={BuildingFormCN('room')}>
                        <div>Room #{j}</div>
                        <div className={BuildingFormCN('input-field')}>Name: <input type={'text'} value={el.name}
                                                                                    name={'name'}
                                                                                    onChange={e => handleRoomChange(e, i, j)}/>
                        </div>
                        <div className={BuildingFormCN('input-field')}>Area: <input type={'number'} value={el.area}
                                                                                    name={'area'}
                                                                                    onChange={e => handleRoomChange(e, i, j)}/>
                        </div>
                        <div className={BuildingFormCN('input-field')}>Cube: <input type={'number'} value={el.cube}
                                                                                    name={'cube'}
                                                                                    onChange={e => handleRoomChange(e, i, j)}/>
                        </div>
                        <div className={BuildingFormCN('input-field')}>Heating: <input type={'number'}
                                                                                       value={el.heating}
                                                                                       name={'heating'}
                                                                                       onChange={e => handleRoomChange(e, i, j)}/>
                        </div>
                        <div className={BuildingFormCN('input-field')}>Light: <input type={'number'} value={el.light}
                                                                                     name={'light'}
                                                                                     onChange={e => handleRoomChange(e, i, j)}/>
                        </div>
                        <div className={BuildingFormCN('input-field')}>heatingPerUnit: <input type={'number'}
                                                                                              value={el.heatingPerUnit}
                                                                                              name={'heatingPerUnit'}
                                                                                              onChange={e => handleRoomChange(e, i, j)}/>
                        </div>
                        <div className={BuildingFormCN('input-field')}>lightPerUnit: <input type={'number'}
                                                                                            value={el.lightPerUnit}
                                                                                            name={'lightPerUnit'}
                                                                                            onChange={e => handleRoomChange(e, i, j)}/>
                        </div>
                    </div>)
                })}
            </div>)
            offset += rooms.length;
            return floorInputs;

        })}
        <input className={BuildingFormCN('submit')} type={"button"} value={"submit"} disabled={roomInputList.length === 0}
               onClick={e => handleBuildingCreate()}/>
    </div>)
}