import { NavLink } from "react-router";

export function AppNav() {
    return (
        <nav>
            <NavLink to="/">Home..</NavLink> |
            <NavLink to="/page1">Page 1...</NavLink> |
            <NavLink to="/page2">Page 2...</NavLink> |
        </nav>
    );
}
