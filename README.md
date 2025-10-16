# 🧑‍💻 Freelance Project Bidding Platform (Spring Boot)

A simple **Spring Boot backend project** that allows **clients to post freelance projects** and **freelancers to bid** on them — similar to platforms like Upwork or Freelancer.

---

## 📘 Project Overview

This project is a backend system that handles freelance project bidding workflow.

- **Clients** can create projects with budget and skill requirements.
- **Freelancers** can place bids on open projects.
- **Clients** can select one winning bid.
- **Projects** automatically move through stages — `OPEN → IN_PROGRESS → COMPLETED`.

It demonstrates a clear understanding of **REST API design**, **Spring Boot** and **JPA** relationships.

---

## ⚙️ Tech Stack

| Layer | Technology |
|--------|-------------|
| **Language** | Java |
| **Framework** | Spring Boot |
| **Database** | postgresql |
| **ORM Tool** | Spring Data JPA |
| **Build Tool** | Maven |
| **Testing Tool** | Postman (for API testing) |

---

## 🧱 Data Models

### 🗂️ Project
| Field | Type | Description |
|--------|------|-------------|
| projectId | Long | Unique ID of the project |
| clientId | Long | ID of the client who created the project |
| title | String | Project title |
| description | String | Project details |
| budget | Double | Project budget |
| skills | String | Required skills (comma-separated) |
| status | Enum | `OPEN` / `IN_PROGRESS` / `COMPLETED` |

---

### 💰 Bid
| Field | Type | Description |
|--------|------|-------------|
| bidId | Long | Unique ID of the bid |
| freelancerId | Long | ID of the freelancer placing the bid |
| bidAmount | Double | Amount proposed by freelancer |
| deliveryDays | Integer | Estimated delivery time in days |
| status | Enum | `PENDING` / `ACCEPTED` / `REJECTED` |
| project | Project | The project this bid belongs to |

---

## 🧠 Business Rules

1. Projects can **only receive bids** while in `OPEN` status.  
2. Only **one bid** can be accepted per project.  
3. When a bid is accepted:
   - Accepted bid → `ACCEPTED`
   - All other bids → `REJECTED`
   - Project → `IN_PROGRESS`
4. Only `IN_PROGRESS` projects can be marked `COMPLETED`.

---

## 🚀 API Endpoints

### 1️⃣ Create a Project
**POST** `/api/projects`

**Request Body:**
```json
{
  "clientId": 1,
  "title": "E-commerce Website Development",
  "description": "Need a full-stack developer to build an online shopping site.",
  "budget": 5000.0,
  "skills": "Java,Spring Boot,React"
}
````

---

### 2️⃣ Get All Projects by Status

**GET** `/api/projects?status=OPEN`

---

### 3️⃣ Place a Bid on a Project

**POST** `/api/projects/{projectId}/bids`

**Request Body:**

```json
{
  "freelancerId": 101,
  "bidAmount": 4500.0,
  "deliveryDays": 20
}
```

---

### 4️⃣ Get All Bids for a Project

**GET** `/api/projects/{projectId}/bids`

---

### 5️⃣ Select a Winning Bid

**POST** `/api/projects/{projectId}/select-bid/{bidId}`

---

### 6️⃣ Mark a Project as Completed

**POST** `/api/projects/{projectId}/complete`

---

## 💡 Example Workflow

1. Client creates a project → Status = `OPEN`
2. Freelancers place bids → Status = `PENDING`
3. Client selects a bid → That bid = `ACCEPTED`, others = `REJECTED`
4. Project automatically changes to `IN_PROGRESS`
5. Client marks project as `COMPLETED` after work is done

---

## 🧪 Testing with Postman

You can test all APIs using Postman.

Example:

| Action             | Method | URL                                                 |
| ------------------ | ------ | --------------------------------------------------- |
| Create Project     | POST   | `http://localhost:8080/api/projects`                |
| Get Projects       | GET    | `http://localhost:8080/api/projects?status=OPEN`    |
| Place Bid          | POST   | `http://localhost:8080/api/projects/1/bids`         |
| Select Winning Bid | POST   | `http://localhost:8080/api/projects/1/select-bid/2` |
| Complete Project   | POST   | `http://localhost:8080/api/projects/1/complete`     |

---

## 👨‍💻 Author

**Anshul Ramdham**
