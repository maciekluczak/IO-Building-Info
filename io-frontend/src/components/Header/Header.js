import { cn } from '@bem-react/classname'
import {Link} from "react-router-dom";
import './Header.scss'
const HeaderCN = cn('header')
export const Header = ()=>{
    return(<div  className={HeaderCN('container')}>
        <h1 className={HeaderCN('name')}><Link to={'/'}>Building Info</Link></h1>
    </div>)
}