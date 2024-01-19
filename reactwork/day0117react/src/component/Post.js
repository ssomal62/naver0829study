// import React, {useEffect, useState} from 'react';
//
// const Post = () => {
//
//     const [posts, setPosts] = useState([]);
//
//     useEffect(() => {
//         fetch("/guest/list")
//             .then((res) => res.json())
//             .then((data) => setGuestList(data))
//     },[]);
//
//     return (
//         <Layout>
//             <header>
//                 <h1>게시물 목록</h1>
//             </header>
//             <main>
//                 {posts.map({gnum, nickName, content, photo}) => (
//                     <article key = {gnum}>
//                         <h3>
//                             {nickName}
//                         </h3>
//                         <p>{content}</p>
//                     </article>
//                     ))}
//             </main>
//         </Layout>
//     );
// };
//
// export default Post;
